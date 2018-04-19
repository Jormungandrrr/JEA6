import { Message } from './Message';

export class Profile {
  biography: string;
  following: Profile[];
  id: number;
  location: string;
  messages: Message[];
  name: string;

  constructor(biography: string, id: number, location: string, name: string) {
    this.biography = biography;
    this.id = id;
    this.location = location;
    this.name = name;
  }
}
