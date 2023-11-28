import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { PlayerListComponent } from './player-list/player-list.component';
import { PlayerFormComponent } from './player-form/player-form.component';
import {FormsModule} from "@angular/forms";
import {HttpClientModule} from "@angular/common/http";
import {PlayerService} from "./services/player-service.service";
import { ClubListComponent } from './club-list/club-list.component';
import { AddNewClubFormComponent } from './add-new-club-form/add-new-club-form.component';

@NgModule({
  declarations: [
    AppComponent,
    PlayerListComponent,
    PlayerFormComponent,
    ClubListComponent,
    AddNewClubFormComponent
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