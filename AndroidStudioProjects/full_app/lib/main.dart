import 'dart:async';

import 'package:flutter/material.dart';
import 'package:full_app/screens/user-info.dart';
import 'package:google_maps_flutter/google_maps_flutter.dart';

void main() => runApp(MyApp());

class MyApp extends StatelessWidget {
  @override
  Widget build(BuildContext context) {
    return const MaterialApp(
      home: UserDetail(),
    );
  }
}
