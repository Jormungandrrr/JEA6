export class Raid {
  gymName: string;
  boss: string;
  lat: number;
  lng: number;
  time: number;
  players?: any;

  constructor(gymName: string, boss: string, lat: number, lng: number, time: number) {
    this.gymName = gymName;
    this.boss = boss;
    this.lat = lat;
    this.lng = lng;
    this.time = time;
  }
}
