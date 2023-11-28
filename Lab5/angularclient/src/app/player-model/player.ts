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
export class PlayersTab {
  players: Player[];

  constructor() {
    this.players = [];
  }
}
