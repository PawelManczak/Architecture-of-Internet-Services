import {Component} from '@angular/core';
import {PutClub} from "../../club-model/put-club";
import {Router} from "@angular/router";
import {ClubService} from "../../services/club-service.service";

@Component({
    selector: 'app-add-new-club-form',
    templateUrl: './add-new-club-form.component.html',
    styleUrls: ['./add-new-club-form.component.css']
})
export class AddNewClubFormComponent {
    club: PutClub;

    constructor(
        private router: Router,
        private clubService: ClubService) {
        this.club = new PutClub();
    }

    onSubmit() {
        this.clubService.save(this.club).subscribe(result => this.goToClubList());
    }

    goToClubList() {
        this.router.navigate(['/clubs']);
    }
}
