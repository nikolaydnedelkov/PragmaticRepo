package spotify.user.convertor;

import org.modelmapper.ModelMapper;
import spotify.user.model.UserModel;
import spotify.user.repository.User;

public class UserConvertor {

    private final ModelMapper modelMapper;

    public UserConvertor(ModelMapper modelMapper) {
        this.modelMapper = modelMapper;
    }

    public UserModel convertToModel(User user) {
        UserModel userModel = modelMapper.map(user, UserModel.class);
        userModel.setFirstName(user.getFirstName());
        userModel.setLastName(user.getFirstName());
        userModel.setEmail(user.getEmail());
        userModel.setBirthDate(user.getBirthDate());
        userModel.setHasPaidApp(user.isHasPaidApp());
        userModel.setId(user.getId());
        return userModel;
    }

    public User convertToEntity(UserModel userModel) {
        User user = modelMapper.map(userModel, User.class);
        user.setFirstName(userModel.getFirstName());
        user.setLastName(userModel.getLastName());
        user.setEmail(userModel.getEmail());
        user.setBirthDate(userModel.getBirthDate());
        user.setHasPaidApp(userModel.isHasPaidApp());
        user.setId(userModel.getId());
        return user;
    }

}

