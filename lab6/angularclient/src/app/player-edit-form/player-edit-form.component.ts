import { Component } from '@angular/core';
import {ClubDetails} from "../club-model/club-details";
import {PatchClubRequest} from "../club-model/patch-club-request";
import {ActivatedRoute, Router} from "@angular/router";
import {ClubService} from "../services/club-service.service";
import {PlayerDetails} from "../player-details";
import {PlayerService} from "../services/player-service.service";
import {PatchPlayerRequest} from "../patch-player-request";

@Component({
  selector: 'app-player-edit-form',
  templateUrl: './player-edit-form.component.html',
  styleUrls: ['./player-edit-form.component.css']
})
export class PlayerEditFormComponent {
  playerDetails: PlayerDetails | undefined;
  player: PatchPlayerRequest | undefined;
  id: number = -1;
  clubId: number = -1;

  constructor(
      private route: ActivatedRoute,
      private router: Router,
      private playerService: PlayerService) {
  }

  ngOnInit() {
    this.route.params.subscribe(params => {
      this.id = +params['id'];
      this.clubId = +params['clubId']
      this.loadClubDetails();
    });
  }

  loadClubDetails() {
     this.playerService.findOne(this.id).subscribe(
        (data: PlayerDetails) =>{
          this.playerDetails = data;
          this.player = new PatchPlayerRequest(this.playerDetails.uuid, this.playerDetails.name, this.clubId, this.playerDetails.overall);
        }
    )
  }

  onSubmit() {

    this.playerService.edit(this.player!!).subscribe(
        result => this.goToClubList(),
        error => {
          console.error("error while editing:", error);
        }
    );
  }

  goToClubList() {
    this.router.navigate(['/clubs']);
  }
}
