class User {
  String name;
  int age;
  String email;

  User(this.name, this.age, this.email);

  Map<String, dynamic> toJson() {
    final _data = <String, dynamic>{};
    _data["name"] = name;
    _data["age"] = age;
    _data["email"] = email;

    return _data;
  }

  @override
  String toString() {
    return 'User{name: $name, age: $age, email: $email}';
  }
}
