package whisit.core;

import org.apache.commons.io.FilenameUtils;
import org.junit.Before;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.http.HttpMethod;
import org.springframework.http.client.ClientHttpRequest;
import org.springframework.http.client.ClientHttpResponse;
import org.springframework.http.client.HttpComponentsClientHttpRequestFactory;
import org.springframework.mock.web.MockHttpSession;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import java.io.File;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.URI;


/**
 * Created by dineshgurumurthy on 12/3/15.
 */

@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(Application.class)
@ActiveProfiles("dev")
@EnableAsync
@WebAppConfiguration
public abstract class AbstractTestClass {

    @Autowired
    private WebApplicationContext wac;

    private MockMvc mockMvc;

    @Before
    public void setup() {
        this.mockMvc = MockMvcBuilders.webAppContextSetup(this.wac).build();
        MockHttpSession mocksession = new MockHttpSession();

    }

    public static void getImageFile(String baseDir, String url) {
        try {


            HttpComponentsClientHttpRequestFactory factory = new HttpComponentsClientHttpRequestFactory();

            ClientHttpRequest clientHttpRequest;

            File file = new File(baseDir + "/" + FilenameUtils.getName(url));

            clientHttpRequest = factory.createRequest(new URI(url), HttpMethod.GET);
            ClientHttpResponse clientHttpResponse = clientHttpRequest.execute();
            InputStream inputStream = clientHttpResponse.getBody();
            OutputStream outputStream = new FileOutputStream(file);

            int read = 0;
            byte[] bytes = new byte[1024];

            while ((read = inputStream.read(bytes)) != -1) {
                outputStream.write(bytes, 0, read);
            }
        } catch (Exception e) {
            LOG.error(e.getMessage(), e);
        }
    }

    public static Logger LOG = LoggerFactory.getLogger(AbstractTestClass.class);

    public Logger LOGGER = LoggerFactory.getLogger(this.getClass());

}
