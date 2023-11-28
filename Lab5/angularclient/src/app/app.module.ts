import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { PlayerListComponent } from './player-list/player-list.component';
import { PlayerFormComponent } from './player-form/player-form.component';
import {FormsModule} from "@angular/forms";
import {HttpClientModule} from "@angular/common/http";
import {PlayerService} from "./services/player-service.service";
import { ClubListComponent } from './clubComponents/club-list/club-list.component';
import { AddNewClubFormComponent } from './clubComponents/add-new-club-form/add-new-club-form.component';
import { EditClubFormComponent } from './clubComponents/edit-club-form/edit-club-form.component';
import { ClubDetailsComponent } from './clubComponents/club-details/club-details.component';
import { PlayerDetailsComponent } from './player-details/player-details.component';
import { PlayerEditFormComponent } from './player-edit-form/player-edit-form.component';

@NgModule({
  declarations: [
    AppComponent,
    PlayerListComponent,
    PlayerFormComponent,
    ClubListComponent,
    AddNewClubFormComponent,
    EditClubFormComponent,
    ClubDetailsComponent,
    PlayerDetailsComponent,
    PlayerEditFormComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    HttpClientModule,
    FormsModule
  ],
  providers: [PlayerService],
  bootstrap: [AppComponent]
})
export class AppModule { }
