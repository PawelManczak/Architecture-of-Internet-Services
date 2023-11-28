export class Player {
  uuid: number;
  name: string;
  clubName: string;

  constructor() {
    this.uuid = 0;
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
