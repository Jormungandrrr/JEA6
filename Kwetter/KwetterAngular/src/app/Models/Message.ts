import {Profile} from './Profile';

export class Message {
  content: string;
  id: number;
  likes: Profile[];
  mentions: Profile[];
  flags: Profile[];
  tags: any[];
  poster: string;
  posterImage: string;
  posterId: number;
  datetime: Date;


  constructor(content: string) {
    this.content = content;
  }
}
