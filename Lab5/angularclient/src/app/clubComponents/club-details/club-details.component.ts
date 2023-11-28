import {Component} from '@angular/core';
import {Club} from "../../club-model/club";
import {ClubService} from "../../services/club-service.service";
import {ActivatedRoute, Router} from "@angular/router";
import {ClubDetails} from "../../club-model/club-details";
import {PatchClubRequest} from "../../club-model/patch-club-request";
import {PlayerService} from "../../services/player-service.service";
import {PlayersFromClub} from "../../players-from-club";
import {Location} from '@angular/common';

@Component({
    selector: 'app-club-details',
    templateUrl: './club-details.component.html',
    styleUrls: ['./club-details.component.css']
})
export class ClubDetailsComponent {
    club: ClubDetails | undefined;
    players: PlayersFromClub | undefined
    id = -1

    constructor(
        private route: ActivatedRoute,
        private clubService: ClubService,
        private playerService: PlayerService,
        private router: Router,
        private location: Location
    ) {
    }

    goToAddPlayer() {
        this.router.navigate([`adduser/${this.id}`])
    }

    goToEditPlayer(userId: number) {
        this.router.navigate([`editPlayer/${userId}/${this.id}`])
    }

    deletePlayer(userId: number) {
        this.playerService.delete(userId).subscribe(() => {
            // deleting and refreshing
            this.router.navigateByUrl('/', {skipLocationChange: true}).then(() => {
                this.router.navigate([`clubDetails/${this.id}`]);
            });
        });
    }

    loadClubDetails() {
        this.playerService.getAllFromClub(this.id).subscribe(
            (data: PlayersFromClub) => {
                this.players = data;
            },
            error => {
                console.error("error while fetching details", error);
            }
        );
        this.clubService.findOne(this.id).subscribe(
            (data: ClubDetails) => {
                this.club = data;
            },
            error => {
                console.error("error while fetching details", error);
            }
        );
    }

    ngOnInit() {
        this.route.params.subscribe(params => {
            this.id = +params['id'];
        });
        this.loadClubDetails();
    }
}
