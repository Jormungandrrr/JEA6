import {Profile} from './Profile';

export class Message {
  content: string;
  id: number;
  likes: number;
  mentions: any[];
  tags: any[];
  poster: string;


  constructor(content: string) {
    this.content = content;
  }
}
