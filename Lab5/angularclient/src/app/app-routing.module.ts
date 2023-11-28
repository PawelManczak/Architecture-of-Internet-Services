import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import {PlayerListComponent} from "./player-list/player-list.component";
import {PlayerFormComponent} from "./player-form/player-form.component";
import {ClubListComponent} from "./club-list/club-list.component";


const routes: Routes = [
  { path: 'users', component: PlayerListComponent },
  { path: 'adduser', component: PlayerFormComponent },
  { path: 'clubs', component: ClubListComponent }
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



