/* Created by Fitz on 2016/12/21 */

package cn.caojunkai.cjkbe.exception;

public class BizException extends RuntimeException {

    public BizException(String message) {
        super(message);
    }

    public BizException(String message, Throwable cause) {
        super(message, cause);
    }

}
