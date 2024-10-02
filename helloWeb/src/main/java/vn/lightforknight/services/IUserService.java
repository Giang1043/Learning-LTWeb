package vn.lightforknight.services;

import vn.lightforknight.models.UserModel;

public interface IUserService {
    UserModel login(String username, String password);
}
