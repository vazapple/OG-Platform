#!/bin/sh
SCRIPTDIR="$(dirname "$0")"

echo "### Creating empty database"

${SCRIPTDIR}/run-tool.sh --chdirtoinstallation \
  com.opengamma.util.test.DbTool \
  -jdbcUrl jdbc:hsqldb:file:data/masterdb/hsqldb/bloombergexample-db \
  -database og-financial \
  -user "OpenGamma" \
  -password "OpenGamma" \
  -drop true \
  -create true \
  -createtables true

${SCRIPTDIR}/run-tool.sh --chdirtoinstallation \
  com.opengamma.util.test.DbTool \
  -jdbcUrl jdbc:hsqldb:file:data/userdb/hsqldb/og-fin-user \
  -database og-financial \
  -user "OpenGamma" \
  -password "OpenGamma" \
  -drop true \
  -create true \
  -createtables true

echo "### Adding Bloomberg example data"

${SCRIPTDIR}/run-tool.sh --chdirtoinstallation \
  -Xms512M \
  -Xmx1024M \
  com.opengamma.bloombergexample.tool.ExampleDatabasePopulator \
  -l tofile-logback.xml \
  -c classpath:toolcontext/toolcontext-bloombergexample-bin.properties

echo "### Completed"
