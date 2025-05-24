### Employee is related to
- LeaveRequest `@OneToMany`
- LeaveBalance `@OneToMany`
- Shift `@OneToOne`
- Attendance `@OneToMany`
- AttendanceReport `@OneToMany`


### LeaveRequest is related to
- Employee `@ManyToOne`

### LeaveBalance is related to
- Employee `@ManyToOne`

### Shift is related to
- Employee `@OneToOne`

### Attendance is related to
- Employee `@ManyToOne`

### AttendanceReport is related to
- Employee `@ManyToOne`