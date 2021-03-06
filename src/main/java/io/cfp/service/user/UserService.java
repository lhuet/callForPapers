/*
 * Copyright (c) 2016 BreizhCamp
 * [http://breizhcamp.org]
 *
 * This file is part of CFP.io.
 *
 * CFP.io is free software: you can redistribute it and/or modify
 * it under the terms of the GNU Affero General Public License as
 * published by the Free Software Foundation, either version 3 of the
 * License, or (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU Affero General Public License for more details.
 *
 * You should have received a copy of the GNU Affero General Public License
 * along with this program. If not, see <http://www.gnu.org/licenses/>.
 */

package io.cfp.service.user;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import io.cfp.dto.user.UserProfil;
import io.cfp.entity.User;
import io.cfp.repository.UserRepo;

@Service
@Transactional
public class UserService {

	private final UserRepo userRepo;

    @Autowired
    public UserService(UserRepo userRepo) {
        this.userRepo = userRepo;
    }

	public User save(User user) {
		return userRepo.save(user);
	}

	public void delete(Integer id) {
		userRepo.delete(id);
	}

	public List<User> findAll() {
		return userRepo.findAll();
	}

	public User findById(Integer id) {
		return userRepo.findOne(id);
	}

	public User findByemail(String email) {
		return userRepo.findByEmail(email);
	}

	public void update(int userId, UserProfil profil) {
		User user = userRepo.findOne(userId) 
            .firstname(profil.getFirstname())
            .lastname(profil.getLastname())
            .email(profil.getEmail())
            .language(profil.getLanguage())
            .bio(profil.getBio())
            .phone(profil.getPhone())
            .company(profil.getCompany())
            .language(profil.getLanguage())
            .github(profil.getGithub())
            .twitter(profil.getTwitter())
            .googleplus(profil.getGoogleplus())
            .imageProfilURL(profil.getImageProfilURL())
            .social(profil.getSocial())
			.gender(profil.getGender())
			.tshirtSize(profil.getTshirtSize());
        userRepo.saveAndFlush(user);
	}
}
