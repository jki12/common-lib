# nhnacademy-common-lib 입니다. 

업데이트시 [nhnacademy-common-maven-repo](https://github.com/nhnacademy-aiot1-T1/nhnacademy-common-maven-repo)에 자동으로 업데이트 후 dooray로 알림을 보내줍니다.


**Maven**
``` xml
<dependency>
    <groupId>com.nhnacademy</groupId>
    <artifactId>common</artifactId>
    <version>${version}</version>
</dependency>

<repositories>
    <repository>
        <id>release</id>
        <url>https://github.com/nhnacademy-aiot1-T1/nhnacademy-common-maven-repo/raw/main/releases</url>
    </repository>
</repositories>
```

