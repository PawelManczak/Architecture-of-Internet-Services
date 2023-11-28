import { Component } from '@angular/core';
import {Player} from "../player-model/player";
import {ActivatedRoute, Router} from "@angular/router";
import {PlayerService} from "../services/player-service.service";
import {PutPlayer} from "../player-model/put-player";

@Component({
  selector: 'app-player-form',
  templateUrl: './player-form.component.html',
  styleUrls: ['./player-form.component.css']
})
export class PlayerFormComponent {
  player: PutPlayer;

  constructor(
    private route: ActivatedRoute,
    private router: Router,
    private userService: PlayerService) {
    this.player = new PutPlayer();
  }

  onSubmit() {
    this.userService.save(this.player).subscribe(result => this.gotoUserList());
  }

  gotoUserList() {
    this.router.navigate(['/users']);
  }
}
