import {Profile} from './Profile';

export class Message {
  content: string;
  id: number;
  likes: number;
  mentions: any[];
  tags: any[];
  poster: string;
  posterImage: string;
  posterId: number;


  constructor(content: string) {
    this.content = content;
  }
}
