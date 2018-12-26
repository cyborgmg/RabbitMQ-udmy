#!/bin/bash
curl -i -u guest:guest -H content-type:application/json -X POST --data @rabbitconf.json http://localhost:15672/api/definitions
