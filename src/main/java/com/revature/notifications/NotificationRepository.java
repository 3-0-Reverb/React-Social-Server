package com.revature.notifications;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Repository
public interface NotificationRepository extends CrudRepository<Notification, String> {

    Optional<Notification> findNotificationById(String id);

    @Query(value = "SELECT * FROM notifications n WHERE n.other_user_id_fk = ?1 AND n.is_read = false", nativeQuery = true)
    Iterable<Notification> findNotificationByOtherUserId(String otherUserId);

    @Modifying
    @Transactional
    @Query("UPDATE Notification SET isRead = true WHERE id = ?1")
    void setAsRead(String id);

}
