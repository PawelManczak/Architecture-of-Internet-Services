import { Injectable } from '@angular/core';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import {map, Observable} from "rxjs";
import {Club, GetClubsResponse} from "../club-model/club";
import {PutPlayer} from "../player-model/put-player";
import {PutClub} from "../club-model/put-club";

@Injectable({
  providedIn: 'root'
})
export class ClubService {
  private clubUrl: string;

  constructor(private http: HttpClient) {
    this.clubUrl = 'http://localhost:8083/api/clubs/';
  }
  public findAll(): Observable<Club[]> {
    return this.http.get<GetClubsResponse>(this.clubUrl ).pipe(
      map(it => it.clubs)
    );
  }

  public delete(id: Number){
    return this.http.delete(`${this.clubUrl}${id.toString()}`);
  }
  public save(player: PutClub): Observable<PutPlayer> {

    return this.http.put<PutPlayer>(this.clubUrl, player );
  }
}
