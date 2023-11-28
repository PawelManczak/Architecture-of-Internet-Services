import { Component } from '@angular/core';
import {ClubDetails} from "../club-model/club-details";
import {ActivatedRoute, Router} from "@angular/router";
import {ClubService} from "../services/club-service.service";
import {PlayerService} from "../services/player-service.service";
import {PlayerDetails} from "../player-details";

@Component({
  selector: 'app-player-details',
  templateUrl: './player-details.component.html',
  styleUrls: ['./player-details.component.css']
})
export class PlayerDetailsComponent {
  player: PlayerDetails | undefined;
  id = -1

  constructor(private route: ActivatedRoute, private playerService: PlayerService, private router: Router) {

  }

  loadClubDetails() {
    this.playerService.findOne(this.id).subscribe(
        (data: PlayerDetails) => {
          this.player = data;
        }
    )
  }
  ngOnInit() {
    this.route.params.subscribe(params => {
      this.id = +params['id'];
    });
    this.loadClubDetails();
  }
}
