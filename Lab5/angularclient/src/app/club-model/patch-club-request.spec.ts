import { PatchClubRequest } from './patch-club-request';

describe('PatchClubRequest', () => {
  it('should create an instance', () => {
    expect(new PatchClubRequest(0, "", 0)).toBeTruthy();
  });
});
