import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import {PlayerListComponent} from "./player-list/player-list.component";
import {PlayerFormComponent} from "./player-form/player-form.component";
import {ClubListComponent} from "./clubComponents/club-list/club-list.component";
import {AddNewClubFormComponent} from "./clubComponents/add-new-club-form/add-new-club-form.component";
import {EditClubFormComponent} from "./clubComponents/edit-club-form/edit-club-form.component";
import {ClubDetailsComponent} from "./clubComponents/club-details/club-details.component";
import {PlayerDetailsComponent} from "./player-details/player-details.component";
import {PlayerEditFormComponent} from "./player-edit-form/player-edit-form.component";


const routes: Routes = [
  { path: 'users', component: PlayerListComponent },
  { path: 'adduser/:id', component: PlayerFormComponent },
  { path: 'clubs', component: ClubListComponent },
  { path: 'addClub', component: AddNewClubFormComponent },
  { path: 'editClub/:id', component: EditClubFormComponent},
  { path: 'clubDetails/:id', component: ClubDetailsComponent},
  { path: 'playerDetails/:id', component: PlayerDetailsComponent},
  { path: 'editPlayer/:id/:clubId', component: PlayerEditFormComponent},

];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }



