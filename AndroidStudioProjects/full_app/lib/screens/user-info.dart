import 'dart:convert';
import 'package:flutter/material.dart';
import 'package:full_app/screens/home.dart';
import 'package:full_app/screens/user.dart';
import 'package:http/http.dart' as http;

class UserDetail extends StatefulWidget {
  const UserDetail({Key? key}) : super(key: key);

  @override
  State<UserDetail> createState() => _UserDetailState();
}

class _UserDetailState extends State<UserDetail> {
  String? _name;
  int? _age;
  String? _email;
  static final client = http.Client();

  sendData() async {
    if (!_formkey.currentState!.validate()) {
      return;
    }

    _formkey.currentState?.save();
    User user = User(_name!, _age!, _email!);

    print("Sent..$user");
    Map<String, String> postHeaders = {"Content-Type": "application/json"};
    var response;
    try {
      response = await client.post(
          Uri.parse("http://192.168.1.135:3000/user/add"),
          headers: postHeaders,
          body: json.encode({"name": _name, "age": _age, "email": _email}));

      print('response.body = ${response.body}');
    } catch (err) {
      print(err.toString());
    }

    return response;
  }

  Widget _buildName() {
    return TextFormField(
      decoration: const InputDecoration(labelText: "Name"),
      validator: (String? value) {
        if (value!.isEmpty) {
          return "Name is requaired";
        }
      },
      onSaved: (String? value) {
        _name = value;
      },
    );
  }

  Widget _buildAge() {
    return TextFormField(
      decoration: const InputDecoration(labelText: "Age"),
      validator: (String? value) {
        if (value!.isEmpty) {
          return "Age is requaired";
        }

        if (!RegExp('[0-9]').hasMatch(value)) {
          return "Please only numbers allowed";
        }
      },
      onSaved: (String? value) {
        _age = int.parse(value!);
      },
    );
  }

  Widget _buildEmail() {
    return TextFormField(
      decoration: const InputDecoration(labelText: "Email"),
      validator: (String? value) {
        if (value!.isEmpty) {
          return "Email is requaired";
        }
      },
      onSaved: (String? value) {
        _email = value;
      },
    );
  }

  GlobalKey<FormState> _formkey = GlobalKey();

  @override
  Widget build(BuildContext context) {
    return Form(
      key: _formkey,
      child: Scaffold(
        appBar: AppBar(
          title: const Text('User Detail'),
        ),
        body: Padding(
          padding: const EdgeInsets.all(20),
          child: Column(
            mainAxisAlignment: MainAxisAlignment.center,
            children: [
              _buildName(),
              _buildAge(),
              _buildEmail(),
              const SizedBox(height: 10),
              MaterialButton(
                onPressed: sendData,
                color: Colors.blue[200],
                child: Row(
                  mainAxisAlignment: MainAxisAlignment.center,
                  children: const [
                    Icon(Icons.person),
                    SizedBox(width: 10),
                    Text(
                      "Submit",
                      style:
                          TextStyle(fontSize: 16, fontWeight: FontWeight.bold),
                    ),
                  ],
                ),
              ),
              MaterialButton(
                onPressed: () {
                  Navigator.of(context).push(
                    MaterialPageRoute(builder: (context) => const Home()),
                  );
                },
                child: const Text(
                  'Open',
                  style: TextStyle(fontWeight: FontWeight.bold),
                ),
              )
            ],
          ),
        ),
      ),
    );
  }
}
