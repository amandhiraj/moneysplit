import React, { useContext, useState, useEffect } from 'react';
import { Box, TextField, Button, Snackbar, IconButton } from '@mui/material';
import FileCopyIcon from '@mui/icons-material/FileCopy';
import { GlobalContext } from '../../context/GlobalState';

const ShareBox = () => {
    const { expense } = useContext(GlobalContext);
    const [shareLink, setShareLink] = useState('');
    const [copySuccess, setCopySuccess] = useState(false);

    useEffect(() => {
        if (expense && expense.groupId) {
            setShareLink(`https://localhost:8080/split/${expense.groupId}`);
        }
    }, [expense]);

    const handleCopy = () => {
        navigator.clipboard.writeText(shareLink);
        setCopySuccess(true);
    };

    const handleCloseSnackbar = () => {
        setCopySuccess(false);
    };

    return (
        <Box
            className={"share-box"}
            bottom={0}
            right={0}
            p={2}
            borderLeft="1px solid #ccc"
            width={{ xs: '100%', sm: 'auto' }}
        >
            <TextField
                label="Use this link to share or edit with your friends: "
                variant="outlined"
                fullWidth
                value={shareLink}
                InputProps={{
                    readOnly: true,
                }}
            />
            <Box mt={1}>
                <Button
                    variant="contained"
                    color="primary"
                    onClick={handleCopy}
                    startIcon={<FileCopyIcon />}
                    fullWidth
                >
                    Copy Link
                </Button>
            </Box>
            <Snackbar
                anchorOrigin={{
                    vertical: 'bottom',
                    horizontal: 'left',
                }}
                open={copySuccess}
                autoHideDuration={3000}
                onClose={handleCloseSnackbar}
                message="Link copied to clipboard!"
                action={
                    <IconButton
                        size="small"
                        aria-label="close"
                        color="inherit"
                        onClick={handleCloseSnackbar}
                    >
                        <FileCopyIcon fontSize="small" />
                    </IconButton>
                }
            />
        </Box>
    );
};

export {ShareBox};
