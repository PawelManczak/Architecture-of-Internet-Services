export class PatchPlayerRequest {
    id: number;
    name: string;
    clubId: number;
    overall: number;

    constructor(id: number, name: string, clubId: number,overall: number) {
        this.id = id;
        this.name = name;
        this.clubId = clubId;
        this.overall = overall;
    }
}
