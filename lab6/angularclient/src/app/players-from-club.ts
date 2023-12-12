export class PlayersFromClub {
    players: Player[];

    constructor() {
        this.players = [];
    }
}

export class Player {
    id: number;
    name: string;
    clubName: string;

    constructor() {
        this.id = 0;
        this.name = '';
        this.clubName = '';
    }
}
