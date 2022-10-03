import 'package:flutter/material.dart';
import 'package:full_app/screens/user.dart';

class Home extends StatefulWidget {
  const Home({Key? key}) : super(key: key);

  @override
  State<Home> createState() => _HomeState();
}

@override
void initState() {
  print('Welcome');
}

class _HomeState extends State<Home> {
  List<User>? users;
 
  @override
  Widget build(BuildContext context) {
    return Scaffold(
      appBar: AppBar(
        title: const Text('Home'),
        leading: const Icon(Icons.home),
      ),
      body: const Center(
        child: Text(
          user.name,
          style: TextStyle(fontWeight: FontWeight.bold),
        ),
      ),
    );
  }
}
