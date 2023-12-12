import { Component } from '@angular/core';
import {PutClub} from "../../club-model/put-club";
import {ActivatedRoute, Router} from "@angular/router";
import {ClubService} from "../../services/club-service.service";
import {PatchClubRequest} from "../../club-model/patch-club-request";
import {ClubDetails} from "../../club-model/club-details";

@Component({
  selector: 'app-edit-club-form',
  templateUrl: './edit-club-form.component.html',
  styleUrls: ['./edit-club-form.component.css']
})
export class EditClubFormComponent {
  clubDetails: ClubDetails | undefined;
  club: PatchClubRequest | undefined;
  id: number = -1;

  constructor(
      private route: ActivatedRoute,
      private router: Router,
      private clubService: ClubService) {
  }

  ngOnInit() {
    this.route.params.subscribe(params => {
      this.id = +params['id']; // Konwertuj parametr 'id' na liczbę
      this.loadClubDetails();
    });
  }

  loadClubDetails() {
    this.clubService.findOne(this.id).subscribe(
        (data: ClubDetails) => {
          this.clubDetails = data;
          this.club = new PatchClubRequest(this.id, this.clubDetails.name, this.clubDetails.stars);
        },
        error => {
          console.error("error while fetching details", error);
        }
    );
  }

  onSubmit() {
    this.clubService.update(this.club!!).subscribe(
        result => this.goToClubList(),
        error => {
          console.error("error while submiting:", error);
        }
    );
  }

  goToClubList() {
    this.router.navigate(['/clubs']);
  }
}

