import { Component } from '@angular/core';
import {Player} from "../player-model/player";
import {PlayerService} from "../services/player-service.service";
import {Club} from "../club-model/club";
import {ClubService} from "../services/club-service.service";
import {Router} from "@angular/router";

@Component({
  selector: 'app-club-list',
  templateUrl: './club-list.component.html',
  styleUrls: ['./club-list.component.css']
})
export class ClubListComponent {
  clubs: Club[] | undefined;

  constructor(private clubService: ClubService, private router: Router) {

  }

  deleteClub(id: number){
    console.log(id)
    this.clubService.delete(id).subscribe(result => this.gotoClubList());
  }
  ngOnInit() {
    this.clubService.findAll().subscribe(data => {
      this.clubs = data;
    });
  }
  gotoClubList() {
    this.router.navigate(['/clubs']);
  }

  goToNewClubForm(){
    this.router.navigate(['/addClub']);
  }
}
