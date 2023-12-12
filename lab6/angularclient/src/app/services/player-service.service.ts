import {Injectable} from '@angular/core';
import {HttpClient, HttpHeaders} from '@angular/common/http';
import {Player, PlayersTab} from "../player-model/player";
import {map, Observable} from "rxjs";
import {PutPlayer} from "../player-model/put-player";
import {PlayerDetails} from "../player-details";
import {PlayersFromClub} from "../players-from-club";
import {PatchPlayerRequest} from "../patch-player-request";

@Injectable({
    providedIn: 'root'
})
export class PlayerService {
    private playerUrl: string;

    constructor(private http: HttpClient) {
        this.playerUrl = 'http://localhost:8083/api/players/';
    }

    public findAll(): Observable<Player[]> {


        return this.http.get<PlayersTab>(this.playerUrl).pipe(
            map(playersTab => playersTab.players)
        );


    }

    public findOne(id: Number): Observable<PlayerDetails> {
        return this.http.get<PlayerDetails>(`${this.playerUrl}${id.toString()}`)
    }

    public getAllFromClub(clubId: number) {
        return this.http.get<PlayersFromClub>(`${this.playerUrl}club/${clubId.toString()}`)
    }

    public save(player: PutPlayer): Observable<PutPlayer> {

        return this.http.put<PutPlayer>(this.playerUrl, player);
    }

    public edit(player: PatchPlayerRequest) {
        return this.http.patch<PatchPlayerRequest>(this.playerUrl, player);
    }

    public delete(id: number) {
        return this.http.delete(`${this.playerUrl}${id.toString()}`);
    }

}
