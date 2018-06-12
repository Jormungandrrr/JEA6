export class Boss {
  tier: number;
  name: string;
  bossCP: number;
  minCP: number;
  maxCP: number;
  catchRate: number;


  constructor(tier: number, name: string, bossCP: number, minCP: number, maxCP: number, catchRate: number) {
    this.tier = tier;
    this.name = name;
    this.bossCP = bossCP;
    this.minCP = minCP;
    this.maxCP = maxCP;
    this.catchRate = catchRate;
  }
}
