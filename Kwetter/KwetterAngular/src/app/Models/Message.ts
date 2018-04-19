export class Message {
  content: string;
  id: number;
  likes: number;
  mentions: any[];
  tags: any[];


  constructor(content: string) {
    this.content = content;
  }
}
