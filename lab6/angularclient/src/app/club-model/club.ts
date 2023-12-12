export class Club {
  id: number;
  clubName: string;

  constructor() {
    this.id = 0;
    this.clubName = '';
  }
}

export class GetClubsResponse {
  clubs: Club[];

  constructor() {
    this.clubs = [];
  }

}
