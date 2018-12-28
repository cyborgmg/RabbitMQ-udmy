FROM rabbitmq:3.7

COPY rabbitconf.json /

RUN rabbitmq-plugins enable --offline rabbitmq_management

RUN set -eux; \
	erl -noinput -eval ' \
		{ ok, AdminBin } = zip:foldl(fun(FileInArchive, GetInfo, GetBin, Acc) -> \
			case Acc of \
				"" -> \
					case lists:suffix("/rabbitmqadmin", FileInArchive) of \
						true -> GetBin(); \
						false -> Acc \
					end; \
				_ -> Acc \
			end \
		end, "", init:get_plain_arguments()), \
		io:format("~s", [ AdminBin ]), \
		init:stop(). \
	' -- /plugins/rabbitmq_management-*.ez > /usr/local/bin/rabbitmqadmin; \
	[ -s /usr/local/bin/rabbitmqadmin ]; \
	chmod +x /usr/local/bin/rabbitmqadmin; \
	apt-get update; \
	apt-get install -y --no-install-recommends python; \
	rm -rf /var/lib/apt/lists/*; \
	rabbitmqadmin --version

ENTRYPOINT ["rabbitmqadmin"]

CMD ["-q","import","/rabbitconf.json"]

EXPOSE 15671 15672 5672 25672