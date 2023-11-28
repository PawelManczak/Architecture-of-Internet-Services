import { Injectable } from '@angular/core';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import {Player, PlayersTab} from "../player-model/player";
import {map, Observable} from "rxjs";
import {PutPlayer} from "../player-model/put-player";

@Injectable({
  providedIn: 'root'
})
export class PlayerService {
  private playerUrl: string;

  constructor(private http: HttpClient) {
    this.playerUrl = 'http://localhost:8083/api/players/';
  }
  public findAll(): Observable<Player[]> {


    return this.http.get<PlayersTab>(this.playerUrl ).pipe(
      map(playersTab => playersTab.players)
    );
  }

  public save(player: PutPlayer): Observable<PutPlayer> {

    return this.http.put<PutPlayer>(this.playerUrl, player );
  }
}
