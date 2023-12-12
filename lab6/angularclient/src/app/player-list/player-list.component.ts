import { Component } from '@angular/core';
import {Player} from "../player-model/player";
import {PlayerService} from "../services/player-service.service";
import {Router} from "@angular/router";

@Component({
  selector: 'app-player-list',
  templateUrl: './player-list.component.html',
  styleUrls: ['./player-list.component.css']
})
export class PlayerListComponent {
  players: Player[] | undefined;

  constructor(private userService: PlayerService, private router: Router) {
  }

  goToDetails(id: number){
      this.router.navigate(['/playerDetails/' + id.toString()]);
  }

  ngOnInit() {
    this.userService.findAll().subscribe(data => {
      this.players = data;
    });
  }
}
