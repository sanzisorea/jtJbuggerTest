package dao;

import edu.msg.ro.persistence.user.entity.Role;
import edu.msg.ro.persistence.user.entity.User;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import java.util.List;

@Stateless(name = "UserManagementImpl", mappedName = "UserManagementImpl")
public class UserManagementImpl implements UserManagement {

    private static final Long serialVersionUID = 1L;

    @PersistenceContext(unitName = "jbugs-persistence")
    EntityManager entityManager;

    @Override
    public void addUser(User user) {
        entityManager.persist(user);
    }

    @Override
    public User updateUser(User user) {
        entityManager.merge(user);
        return user;
    }

    @Override
    public List<User> getAllUsers() {
        Query query = entityManager.createQuery("select u from User u");
        return query.getResultList();
    }

    @Override
    public User getUserForUsername(String username) {
        Query query = entityManager.createQuery("select u from User u where u.username='" + username + "'");
        return (User) query.getSingleResult();
    }

    @Override
    public void deactivateUser(Long id) {
        User user = entityManager.find(User.class, id);
        user.setStatus("Inactive");
        entityManager.merge(user);
    }

    @Override
    public void addRole(Role role) {
        entityManager.persist(role);
    }

    @Override
    public void removeRole(Role role) {
        entityManager.remove(role);
    }

    @Override
    public Role updateRole(Role role) {
        entityManager.merge(role);
        return role;
    }

    @Override
    public Role getRoleForId(Long id) {
        return entityManager.find(Role.class, id);
    }

    @Override
    public List<Role> getAllRoles() {
        Query query = entityManager.createQuery("select r from Role r");
        return query.getResultList();
    }
}
