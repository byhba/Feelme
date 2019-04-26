var Pusher = require('pusher');

var pusher = new Pusher({
  appId: '769790',
  key: '28b88b9f769727f3bf35',
  secret: 'd04ac1767875b3a8ee0b',
  cluster: 'eu',
  encrypted: true
});

pusher.trigger('my-channel', 'my-event', {
  "message": "hello world"
});