import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import {PlayerListComponent} from "./player-list/player-list.component";
import {PlayerFormComponent} from "./player-form/player-form.component";
import {ClubListComponent} from "./clubComponents/club-list/club-list.component";
import {AddNewClubFormComponent} from "./clubComponents/add-new-club-form/add-new-club-form.component";
import {EditClubFormComponent} from "./clubComponents/edit-club-form/edit-club-form.component";


const routes: Routes = [
  { path: 'users', component: PlayerListComponent },
  { path: 'adduser', component: PlayerFormComponent },
  { path: 'clubs', component: ClubListComponent },
  { path: 'addClub', component: AddNewClubFormComponent },
  { path: 'editClub/:id', component: EditClubFormComponent}
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



