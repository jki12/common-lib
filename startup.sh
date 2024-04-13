#!/usr/bin/bash

github_dir="${HOME}/nhnacademy-common-maven-repo/releases/com/nhnacademy/common/" # release된 파일이 들어가야할 dir Path
dir="${github_dir}$(ls -tr ~/target | tail -1 | grep .jar | cut -d '-' -f 2,3 | cut -d '.' -f 1,2,3)" # common-1.0.0-RELEASE -> 1.0.0-RELEASE만 추출, concat github_dir

echo "dir name = ${dir}"

message="release에 실패했습니다."

if [ ! -e ${dir} ]; then
	git config --global user.name "${name}"
	git config --global user.email "${email}"

	git config --global --list

	mkdir ${dir} && cp "${HOME}/target/$(ls -tr ~/target | tail -1)" ${dir} && cd ~/nhnacademy-common-maven-repo && sleep 1s &&  git add . && git commit -m "release" && git push && message="새로운 버전으로 업데이트 되었습니다. 버전을 올려주세요"
fi

/usr/local/java/java11/bin/java -jar ~/dooray-notification-0.0.1-.jar $message # dooray로 현재 상황 알려줌