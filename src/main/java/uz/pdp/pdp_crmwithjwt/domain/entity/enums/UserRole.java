package uz.pdp.pdp_crmwithjwt.domain.entity.enums;

import lombok.Getter;

import java.util.List;

@Getter
public enum UserRole {
    ADMIN(
            List.of(
                    RolePermission.GROUP_ALL,
                    RolePermission.GROUP_READ,
                    RolePermission.GROUP_UPDATE,
                    RolePermission.GROUP_CREATE,
                    RolePermission.GROUP_DELETE,
                    RolePermission.MODULE_ALL,
                    RolePermission.MODULE_READ,
                    RolePermission.MODULE_UPDATE,
                    RolePermission.MODULE_CREATE,
                    RolePermission.MODULE_DELETE,
                    RolePermission.STUDENT_ALL,
                    RolePermission.STUDENT_READ,
                    RolePermission.STUDENT_UPDATE,
                    RolePermission.STUDENT_CREATE,
                    RolePermission.STUDENT_DELETE
            )),
    MENTOR(
            List.of(
                    RolePermission.LESSON_ALL,
                    RolePermission.LESSON_READ,
                    RolePermission.LESSON_UPDATE,
                    RolePermission.LESSON_CREATE,
                    RolePermission.LESSON_DELETE,
                    RolePermission.ATTENDANCE_ALL,
                    RolePermission.ATTENDANCE_READ,
                    RolePermission.ATTENDANCE_UPDATE,
                    RolePermission.ATTENDANCE_CREATE,
                    RolePermission.ATTENDANCE_DELETE
            )),
    DEPARTMENT_HEAD(
            List.of(
                    RolePermission.STAFF_ALL,
                    RolePermission.STAFF_READ,
                    RolePermission.STAFF_UPDATE,
                    RolePermission.STAFF_CREATE,
                    RolePermission.STAFF_DELETE
            )),
    SUPER_ADMIN(
            List.of(
                    RolePermission.DEPARTMENT_ALL,
                    RolePermission.DEPARTMENT_READ,
                    RolePermission.DEPARTMENT_UPDATE,
                    RolePermission.DEPARTMENT_CREATE,
                    RolePermission.DEPARTMENT_DELETE,
                    RolePermission.STAFF_ALL,
                    RolePermission.STAFF_READ,
                    RolePermission.STAFF_UPDATE,
                    RolePermission.STAFF_CREATE,
                    RolePermission.STAFF_DELETE
            ));


    private final List<RolePermission> permissions;

    UserRole(List<RolePermission> permissions) {
        this.permissions = permissions;
    }

}
