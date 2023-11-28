export class PatchClubRequest {
    id: number;
    clubName: string;
    stars: number;

    constructor(id: number, clubName: string, stars: number) {
        this.id = id;
        this.clubName = clubName;
        this.stars = stars;
    }
}
