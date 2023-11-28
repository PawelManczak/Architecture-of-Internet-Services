import { Component } from '@angular/core';
import {Player} from "../player-model/player";
import {PlayerService} from "../services/player-service.service";

@Component({
  selector: 'app-player-list',
  templateUrl: './player-list.component.html',
  styleUrls: ['./player-list.component.css']
})
export class PlayerListComponent {
  players: Player[] | undefined;

  constructor(private userService: PlayerService) {
  }

  ngOnInit() {
    this.userService.findAll().subscribe(data => {
      this.players = data;
    });
  }
}
