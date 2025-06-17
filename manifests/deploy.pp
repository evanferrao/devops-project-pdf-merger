exec { 'install-java':
  command => '/usr/bin/apt-get update && /usr/bin/apt-get install -y openjdk-17-jre',
  unless  => '/usr/bin/java -version 2>&1 | grep "17"',
}

file { '/opt/pdfmerger':
  ensure => directory,
  mode   => '0755',
}

file { '/opt/pdfmerger/pdf-merger.jar':
  ensure => file,
  source => "file:///home/ubuntubox/Desktop/pdf-merger/target/pdf-merger-1.0.0.jar",
  mode   => '0755',
}

file { '/etc/systemd/system/pdfmerger.service':
  ensure  => file,
  content => "[Unit]
Description=PDF Merger App
After=network.target

[Service]
ExecStart=/usr/bin/java -jar /opt/pdfmerger/pdf-merger.jar --server.port=1234
SuccessExitStatus=143
Restart=on-failure
RestartSec=5

[Install]
WantedBy=multi-user.target",
  mode    => '0644',
}

exec { 'reload-systemd':
  command     => '/bin/systemctl daemon-reexec',
  refreshonly => true,
  subscribe   => File['/etc/systemd/system/pdfmerger.service'],
}

service { 'pdfmerger':
  ensure    => running,
  enable    => true,
  subscribe => File['/opt/pdfmerger/pdf-merger.jar'],
}

