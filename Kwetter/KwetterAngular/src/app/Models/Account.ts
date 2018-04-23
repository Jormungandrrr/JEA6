import { Profile } from './Profile';
import {Role} from './Role';

export class Account {
  id: number;
  username: string;
  email: string;
  role: Role;
  profile: Profile;

  constructor(id, username, email, role, profile) {
    this.id = id;
    this.username = name;
    this.email = email;
    this.role = role;
    this.profile = profile;
  }
}
