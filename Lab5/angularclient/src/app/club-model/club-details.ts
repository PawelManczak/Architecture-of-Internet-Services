export class ClubDetails {
    uuid: number;
    name: string;
    players: string[];
    stars: number;

    constructor(uuid: number, name: string, players: string[], stars: number) {
        this.uuid = uuid;
        this.name = name;
        this.players = players;
        this.stars = stars;
    }
}
