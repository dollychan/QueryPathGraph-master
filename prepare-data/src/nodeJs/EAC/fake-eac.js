var Table = require('mysql-faker').Table,
    insert = require('mysql-faker').insert;

var player = (new Table('player', 500000));
player.lorem_words('name')
        .lorem_words('playerFrags')
     .random_number('isAdmin', {min: 0, max: 1});

var server = (new Table('server', 1000));
server.lorem_words('name')
        .lorem_words('ip');

var session = (new Table('session', 2000000));
session.date_past('timeStart')
      .date_past('timeEnded')
      .random_number('player', {min: 1, max: player.count})
      .random_number('server', {min: 1, max: server.count});

var state = (new Table('state', 10000000));
state.random_number('posX', {min: 1, max: 100})
  .random_number('posY', {min: 1, max: 100})
  .random_number('posZ', {min: 1, max: 100})
  .date_past('serverTimestamp')
  .random_number('session', {min: 1, max: session.count});

insert([
  session,
  server,
  player,
  state
], {
  host: 'localhost',
  user: 'root',
  password: 'mysql123',
  database: 'eac_db'
}, true);
